import React, { useEffect, useState } from 'react'
import axios from 'axios'
import {
  Box,
  TextField,
  Button,
  Typography,
  Autocomplete
} from '@mui/material'

export default function RegistrarTrabajador() {
  
  const [empresas, setEmpresas] = useState([])
  const [empresaSeleccionada, setEmpresaSeleccionada] = useState(null)
  const [rut, setRut] = useState('')
  const [nombre, setNombre] = useState('')
  const [apellidoPaterno, setApellidoPaterno] = useState('')
  const [apellidoMaterno, setApellidoMaterno] = useState('')
  const [direccion, setDireccion] = useState('')

  useEffect(() => {
    axios.get('http://localhost:8090/v1/empresas/all')
      .then((response) => {
        setEmpresas(response.data.data)
      })
      .catch((error) => {
        console.error('Error al obtener empresas:', error)
      })
  }, [])

  const handleSubmit = async (e) => {
    e.preventDefault()

    if (!empresaSeleccionada) {
      alert('Por favor, selecciona una empresa')
      return
    }

    try {
      const dataTrabajador = {
        rut,
        nombre,
        apellidoPaterno,
        apellidoMaterno,
        direccion
      }

      await axios.post(
        `http://localhost:8090/v1/trabajadores/empresa/${empresaSeleccionada.id}`,
        dataTrabajador
      )

      alert('Trabajador registrado exitosamente')

      setRut('')
      setNombre('')
      setApellidoPaterno('')
      setApellidoMaterno('')
      setDireccion('')
      setEmpresaSeleccionada(null)
    } catch (error) {
      console.error('Error al registrar trabajador:', error)
      alert('Ocurrió un error al registrar el trabajador')
    }
  }

  return (
    <Box sx={{ p: 2, maxWidth: 400 }}>
      <Typography variant='h5' gutterBottom>
        Registrar Trabajador
      </Typography>

      <form onSubmit={handleSubmit}>
        <Autocomplete
          fullWidth
          value={empresaSeleccionada}
          onChange={(event, newValue) => setEmpresaSeleccionada(newValue)}
          options={empresas}
          getOptionLabel={(option) => option.razon_social || ''}
          renderInput={(params) => (
            <TextField
              {...params}
              label='Empresa'
              variant='outlined'
              required
            />
          )}
          sx={{ my: 2 }}
        />

        <TextField
          label='RUT'
          value={rut}
          onChange={(e) => setRut(e.target.value)}
          fullWidth
          margin='normal'
          required
        />

        <TextField
          label='Nombre'
          value={nombre}
          onChange={(e) => setNombre(e.target.value)}
          fullWidth
          margin='normal'
          required
        />

        <TextField
          label='Apellido Paterno'
          value={apellidoPaterno}
          onChange={(e) => setApellidoPaterno(e.target.value)}
          fullWidth
          margin='normal'
          required
        />

        <TextField
          label='Apellido Materno'
          value={apellidoMaterno}
          onChange={(e) => setApellidoMaterno(e.target.value)}
          fullWidth
          margin='normal'
          required
        />

        <TextField
          label='Dirección'
          value={direccion}
          onChange={(e) => setDireccion(e.target.value)}
          fullWidth
          margin='normal'
          required
        />

        <Button type='submit' variant='contained' sx={{ mt: 2 }}>
          Guardar
        </Button>
      </form>
    </Box>
  )
}
