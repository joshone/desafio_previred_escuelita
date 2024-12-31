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

export default function CollapsibleRow({
  empresa,
  onEditEmpresa,
  onEditTrabajador,
  onDeleteEmpresa,
  onDeleteTrabajador
}) {
  const [open, setOpen] = useState(false)

  const handleEditEmpresaClick = () => {
    if (onEditEmpresa) {
      onEditEmpresa(empresa)
    }
  }

  const handleDeleteEmpresaClick = () => {
    if (onDeleteEmpresa) {
      onDeleteEmpresa(empresa)
    }
  }

  const handleEditTrabajadorClick = (trabajador) => {
    if (onEditTrabajador) {
      onEditTrabajador(trabajador, empresa)
    }
  }

  const handleDeleteTrabajadorClick = (trabajador) => {
    if (onDeleteTrabajador) {
      onDeleteTrabajador(trabajador, empresa)
    }
  }

  return (
    <>
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
            sx={{ mr: 1 }}
          >
            Editar
          </Button>

          <Button
            variant='outlined'
            color='error'
            onClick={handleDeleteEmpresaClick}
          >
            Eliminar
          </Button>
        </TableCell>
      </TableRow>

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
                    <MUITableCell>UID</MUITableCell>
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
                      <MUITableCell>{t.uid}</MUITableCell>
                      <MUITableCell>{t.nombre}</MUITableCell>
                      <MUITableCell>
                        {t.apellido_paterno} {t.apellido_materno}
                      </MUITableCell>
                      <MUITableCell>{t.direccion}</MUITableCell>
                      <MUITableCell>
                        <Button
                          variant='outlined'
                          color='secondary'
                          onClick={() => handleEditTrabajadorClick(t)}
                          sx={{ mr: 1 }}
                        >
                          Editar
                        </Button>

                        <Button
                          variant='outlined'
                          color='error'
                          onClick={() => handleDeleteTrabajadorClick(t)}
                        >
                          Eliminar
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
