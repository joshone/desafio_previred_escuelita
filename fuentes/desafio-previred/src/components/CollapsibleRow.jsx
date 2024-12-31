import React, { useState } from 'react'
import {
  IconButton,
  TableRow,
  TableCell,
  Collapse,
  Box,
  Typography,
  Table,
  TableHead,
  TableBody,
  TableRow as MUITableRow,
  TableCell as MUITableCell,
  Button
} from '@mui/material'
import { KeyboardArrowDown, KeyboardArrowUp } from '@mui/icons-material'

export default function CollapsibleRow({ empresa, onEditEmpresa, onEditTrabajador }) {
  const [open, setOpen] = useState(false)

  const handleEditEmpresaClick = () => {
    if (onEditEmpresa) {
      onEditEmpresa(empresa)
    }
  }

  const handleEditTrabajadorClick = (trabajador) => {
    if (onEditTrabajador) {
      onEditTrabajador(trabajador, empresa)
    }
  }

  return (
    <>
      {/* Fila principal empresas */}
      <TableRow>
        <TableCell>
          <IconButton
            aria-label='expand row'
            size='small'
            onClick={() => setOpen(!open)}
          >
            {open ? <KeyboardArrowUp /> : <KeyboardArrowDown />}
          </IconButton>
        </TableCell>

        <TableCell>{empresa.rut}</TableCell>
        <TableCell>{empresa.uid}</TableCell>
        <TableCell>{empresa.razon_social}</TableCell>
        <TableCell>{empresa.created_at}</TableCell>
        <TableCell>{empresa.status}</TableCell>

        <TableCell>
          <Button
            variant='outlined'
            color='primary'
            onClick={handleEditEmpresaClick}
          >
            Editar
          </Button>
        </TableCell>
      </TableRow>

      {/* Fila colapsable (trabajadores) */}
      <TableRow>
        <TableCell style={{ paddingBottom: 0, paddingTop: 0 }} colSpan={5}>
          <Collapse in={open} timeout='auto' unmountOnExit>
            <Box margin={1}>
              <Typography variant='subtitle1' gutterBottom>
                Trabajadores
              </Typography>
              <Table size='small' aria-label='trabajadores'>
                <TableHead>
                  <MUITableRow>
                    <MUITableCell>RUT</MUITableCell>
                    <MUITableCell>Nombre</MUITableCell>
                    <MUITableCell>Apellidos</MUITableCell>
                    <MUITableCell>Dirección</MUITableCell>
                    <MUITableCell>Acciones</MUITableCell>
                  </MUITableRow>
                </TableHead>
                <TableBody>
                  {empresa.trabajadores?.map((t, idx) => (
                    <MUITableRow key={idx}>
                      <MUITableCell>{t.rut}</MUITableCell>
                      <MUITableCell>{t.nombre}</MUITableCell>
                      <MUITableCell>
                        {t.apellidoPaterno} {t.apellidoMaterno}
                      </MUITableCell>
                      <MUITableCell>{t.direccion}</MUITableCell>
                      <MUITableCell>
                        <Button
                          variant='outlined'
                          color='secondary'
                          onClick={() => handleEditTrabajadorClick(t)}
                        >
                          Editar
                        </Button>
                      </MUITableCell>
                    </MUITableRow>
                  ))}
                </TableBody>
              </Table>
            </Box>
          </Collapse>
        </TableCell>
      </TableRow>
    </>
  )
}