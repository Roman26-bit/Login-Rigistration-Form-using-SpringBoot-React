
import { BrowserRouter, Routes, Route } from 'react-router-dom'
import './App.css'
import LoginForm from './pages/LoginForm'
import RegistrationFrom from './pages/RegistrationFrom'
import Dashboard from './pages/Dashboard'
import { Toaster } from 'react-hot-toast'
import ProtectedRoute from './pages/ProtectedRoute'





function App() {

  return (
    <>
    <BrowserRouter>
      <Toaster position='bottom-right' reverseOrder={false} />
      <Routes>
        <Route  path="/" element={<RegistrationFrom />} />
        <Route path="/login" element={<LoginForm />} />
        <Route path="/dashboard" element={ <ProtectedRoute><Dashboard /></ProtectedRoute> } />
      </Routes>
    </BrowserRouter>
    </>
  )
}

export default App
