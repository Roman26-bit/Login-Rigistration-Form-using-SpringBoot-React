import React from 'react'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faUser,faEnvelope,faLock,faPhone,faCircleUser } from '@fortawesome/free-solid-svg-icons'
import { useState } from 'react'
import { Link, useNavigate } from 'react-router-dom';
import toast from 'react-hot-toast';


export default function LoginForm() {
  const [formData,setFormdata] = useState(
    {
      email : "",
      password : ""
    }
  );

  const handelFormData = (e)=>{
    const {name,value} = e.target;
    setFormdata((perviousState)=>({...perviousState,[name]:value}))
  }

  const navigate = useNavigate();

  const submitdata = async(e) => {
    e.preventDefault();
    try {
      const response = await fetch("http://localhost:8080/form/login",
        {
          method : "POST",
          headers : {"Content-Type" : "application/json"},
          body :  JSON.stringify(formData)
        }
      );

      const data = await response.json();

      if (!response.ok) {
        throw new Error(data.message || "Login failed");
      }

      localStorage.setItem("token",data.JwtToken);


      toast.success("Login Successful...")
      console.log(data);
      
      navigate("/dashboard")
    } catch (error) {
      toast.error(error.message);
    }
  }

   return (
    <div className='min-h-screen grid grid-cols-2'>
      <div className='flex items-center bg-blue-400'>
      <div className='ml-15 '>
        <div>
          <div>
            <div className=' float-left'> 
              <img src="/public/vite.svg" alt="" className='mt-2 mr-2'/>
            </div>
            <div>
              <h3 className='text-2xl font-bold'>AttendTrack</h3>
              <p>Anomaly Detection System</p>
            </div>
          </div>
          <div>
            <h1 className='text-3xl font-bold my-5'>Smart Attendance <br />Management Made Easy</h1>
            <ul className=' list-disc ml-5 leading-8'>
              <li>Real-time Attendance tracking with camera verification</li>
              <li>Automatic annomaly Dection fror attendance drop</li>
              <li>Weekly & monthly analytics with visual reports</li>
            </ul>
          </div>
        </div>
        </div>
      </div>
      <div  className='flex items-center ml-30'>
        <div>
            <div className=' flex-col justify-center justify-items-center'>
              <h2 className='font-bold text-2xl mb-2'>Login</h2>
              <p className='font-semibold text-zinc-500'>Start managing attendence today</p>
            </div>
            <div className=' leading-8 my-4'>
              <form onSubmit={submitdata}>
                <label htmlFor="email"><FontAwesomeIcon icon={faEnvelope} />Email</label><br />
                <input value={formData.email} onChange={handelFormData} className=' border-gray-400 mb-1.5 border rounded-md min-w-md px-2' type="email" name="email" placeholder='admin@school.com' required/><br />
                <label  htmlFor="passwprd"><FontAwesomeIcon icon={faLock} />Password</label><br />
                <input value={formData.password} onChange={handelFormData} className=' min-w-md px-2 mb-1.5  border-gray-400 border rounded-md' type="password" name="password" placeholder='...............' required/><br />
                <div className=' min-w-md flex justify-center mt-4 bg-blue-950 rounded-md p-1 items-center  text-white'><button className='min-w-full hover:cursor-pointer' type="submit">Login </button></div>
              </form>
              <div><p className='text-neutral-500'>New Uesr : <Link to="/" className='text-blue-600 font-semibold'>Register here</Link></p> </div>
            </div>
        </div>
      </div>
    </div>
  )
}
