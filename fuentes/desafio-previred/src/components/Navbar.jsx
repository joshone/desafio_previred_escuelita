import React from 'react'
import { AppBar, Toolbar, Typography, Button, Box } from '@mui/material'
import { Link } from 'react-router-dom'

export default function Navbar() {
  return (
    <AppBar position="static">
      <Toolbar>
        <Typography variant="h6">Previred App</Typography>
        <Box sx={{ flexGrow: 1 }} />

        <Button color="inherit" component={Link} to="/">
          Home
        </Button>
        <Button color="inherit" component={Link} to="/registrar-empresa">
          Registrar Empresa
        </Button>
        <Button color="inherit" component={Link} to="/registrar-trabajador">
          Registrar Trabajador
        </Button>
      </Toolbar>
    </AppBar>
  )
}
