import React, { useState } from 'react'
import axios from 'axios'
import { Box, TextField, Button, Typography } from '@mui/material'

export default function RegistrarEmpresa() {
  const [rut, setRut] = useState('')
  const [razonSocial, setRazonSocial] = useState('')

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const data = {
        rut,
        razon_social: razonSocial
      }
      const response = await axios.post('http://localhost:8090/v1/empresas/create', data)
      console.log('Empresa creada:', response.data)
      alert('Empresa registrada correctamente')
      
      // limpiar campos
      setRut('')
      setRazonSocial('');
    } catch (error) {
      console.error('Error al registrar empresa:', error)
      alert('Ocurrió un error al registrar la empresa')
    }
  }

  return (
    <Box sx={{ p: 2, maxWidth: 400 }}>
      <Typography variant="h5" gutterBottom>
        Registrar Empresa
      </Typography>
      <form onSubmit={handleSubmit}>
        <TextField
          label="RUT"
          value={rut}
          onChange={(e) => setRut(e.target.value)}
          fullWidth
          margin="normal"
          required
        />
        <TextField
          label="Razón Social"
          value={razonSocial}
          onChange={(e) => setRazonSocial(e.target.value)}
          fullWidth
          margin="normal"
          required
        />

        <Button type="submit" variant="contained" sx={{ mt: 2 }}>
          Guardar
        </Button>
      </form>
    </Box>
  )
}
