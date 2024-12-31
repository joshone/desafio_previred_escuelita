import React from 'react'
import { BrowserRouter, Routes, Route } from 'react-router-dom'
import Navbar from './components/Navbar'
import Home from './pages/Home'
import RegistrarEmpresa from './pages/RegistrarEmpresa'
import RegistrarTrabajador from './pages/RegistrarTrabajador'

function App() {
  return (
    <BrowserRouter>
      <Navbar />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/registrar-empresa" element={<RegistrarEmpresa />} />
        <Route path="/registrar-trabajador" element={<RegistrarTrabajador />} />
      </Routes>
    </BrowserRouter>
  )
}

export default App
