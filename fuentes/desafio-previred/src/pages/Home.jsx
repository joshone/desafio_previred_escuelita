import React, { useEffect, useState } from 'react'
import axios from 'axios'
import {
  TableContainer,
  Table,
  TableHead,
  TableBody,
  TableRow,
  TableCell,
  Paper,
  Typography,
  Box
} from '@mui/material'

import CollapsibleRow from '../components/CollapsibleRow'

export default function Home() {
  const [empresas, setEmpresas] = useState([])

  useEffect(() => {
    axios.get('http://localhost:8090/v1/empresas/all')
      .then((response) => {
        console.log(response.data)
        let data = response.data.data
        setEmpresas(data)
      })
      .catch((error) => {
        console.error('Error al obtener empresas:', error)
      })
  }, [])

  const handleEditEmpresa = (empresa) => {
    console.log('Editar empresa:', empresa)
    alert(`Editar empresa: ${empresa.rut}`)
  }

  const handleEditTrabajador = (trabajador, empresa) => {
    console.log('Editar trabajador:', trabajador, 'de la empresa:', empresa)
    alert(`Editar trabajador: ${trabajador.rut} (Empresa: ${empresa.rut})`)
  }

  const handleDeleteEmpresa = async (empresa) => {
    console.log('Eliminar empresa:', empresa)

    if (!window.confirm(`¿Seguro deseas eliminar la empresa ${empresa.rut}?`)) {
      return
    }

    try {
      await axios.delete(`http://localhost:8090/v1/empresas/${empresa.uid}`)

      alert(`Empresa eliminada: ${empresa.rut}`)
      const nuevaLista = empresas.filter(e => e.id !== empresa.id)
      setEmpresas(nuevaLista)

    } catch (error) {
      console.error('Error al eliminar empresa:', error)
      alert('Ocurrió un error al eliminar la empresa')
    }
  }

  const handleDeleteTrabajador = async (trabajador, empresa) => {
    console.log('Eliminar trabajador:', trabajador, 'de la empresa:', empresa)

    if (!window.confirm(`¿Seguro deseas eliminar al trabajador ${trabajador.rut}?`)) {
      return
    }

    try {
      await axios.delete(`http://localhost:8090/v1/trabajador/${trabajador.uid}`)

      alert(`Trabajador ${trabajador.rut} eliminado correctamente`)

      const nuevasEmpresas = empresas.map(e => {
        if (e.id === empresa.id) {
          return {
            ...e,
            trabajadores: e.trabajadores.filter(t => t.id !== trabajador.id)
          }
        }
        return e
      })

      setEmpresas(nuevasEmpresas)

    } catch (error) {
      console.error('Error al eliminar trabajador:', error)
      alert('Ocurrió un error al eliminar el trabajador')
    }
  }

  return (
    <Box sx={{ p: 2 }}>
      <Typography variant='h5' gutterBottom>
        Empresas Registradas
      </Typography>

      <TableContainer component={Paper}>
        <Table>
          <TableHead>
            <TableRow>
              <TableCell />
              <TableCell>RUT</TableCell>
              <TableCell>UID</TableCell>
              <TableCell>Razón Social</TableCell>
              <TableCell>Fecha Inserción</TableCell>
              <TableCell>Status</TableCell>
              <TableCell>Acciones</TableCell>
            </TableRow>
          </TableHead>

          <TableBody>
            {empresas.map((empresa, idx) => (
              <CollapsibleRow
                key={idx}
                empresa={empresa}
                onEditEmpresa={handleEditEmpresa}
                onEditTrabajador={handleEditTrabajador}
                onDeleteEmpresa={handleDeleteEmpresa}
                onDeleteTrabajador={handleDeleteTrabajador}
              />
            ))}
          </TableBody>
        </Table>
      </TableContainer>
    </Box>
  )
}
