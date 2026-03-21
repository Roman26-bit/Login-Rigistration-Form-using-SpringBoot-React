
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faUser,faEnvelope,faLock,faPhone,faCircleUser } from '@fortawesome/free-solid-svg-icons'
import { useState } from 'react'
import { Link, useNavigate } from "react-router-dom";
import toast from 'react-hot-toast';

export default function RegistrationFrom() {

  const [formData,setFormdata]= useState(
    {
      name : "",
      email :"",
      password :"",
      phoneNumber :"",
      role :""
    }
  )

    const navigate = useNavigate();

const handlesubmit = async(e) =>{
  e.preventDefault();
  try {
    const response = await fetch("http://localhost:8080/form/registration",
      {
        method : "POST",
        headers : {"Content-Type" : "application/json"},
        body : JSON.stringify(formData)
      }
    );

     const data = await response.json();

    if (!response.ok) {
      throw new Error(data.message || "!... Registration Failed");
    }

   
    console.log(data);
    toast.success("Registered Successfully ✅");
    navigate("/login");
  } catch (error) {
    console.log(error);
    toast.error(error.message);
  }
}

  const assigningFormData = (e)=>{
    const {name,value} = e.target;
    setFormdata((perviousState)=>({...perviousState,[name]:value}));
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
            <div><h2 className=' font-bold text-2xl mb-2'>Creat Account</h2><p className=' font-semibold text-zinc-500'>Start managing attendence today</p></div>
            <div className=' leading-8 my-4'>
              <form onSubmit={handlesubmit}>
                <label htmlFor="name"><FontAwesomeIcon icon={faUser} />Full Name</label><br />
                <input value={formData.name} onChange={assigningFormData} className=' border-gray-400  mb-1.5 border rounded-md min-w-md px-2 ' type="text" name="name" placeholder='john' required/> <br />
                <label htmlFor="email"><FontAwesomeIcon icon={faEnvelope} />Email</label><br />
                <input value={formData.email} onChange={assigningFormData} className=' border-gray-400 mb-1.5 border rounded-md min-w-md px-2' type="email" name="email" placeholder='admin@school.com' required/><br />
                <label htmlFor="passwprd"><FontAwesomeIcon icon={faLock} />Password</label><br />
                <input value={formData.password} onChange={assigningFormData} className=' min-w-md px-2 mb-1.5  border-gray-400 border rounded-md' type="password" name="password" placeholder='...............' required/><br />
                <label htmlFor="phoneNumber"><FontAwesomeIcon icon={faPhone} />PhoneNumber</label><br />
                <input value={formData.phoneNumber} onChange={assigningFormData} pattern="[0-9]{10}" title="Enter a valid 10-digit phone number" className=' border-gray-400  mb-1.5 border rounded-md min-w-md px-2 ' placeholder='phonenumber' type="tel" name="phoneNumber" id="" required/><br />
                <label htmlFor="role"><FontAwesomeIcon icon={faCircleUser} />Role</label><br />
                <select value={formData.role} onChange={assigningFormData}  className=' border-gray-400 mb-1.5 border rounded-md min-w-md px-2 py-1' name="role" id="" required><option value="">SELECT</option><option value="ADMIN">ADMIN</option><option value="STUDENT">STUDENT</option></select>
                <div className=' min-w-md flex justify-center mt-4 bg-blue-950 rounded-md p-1 items-center  text-white'><button className='min-w-full hover:cursor-pointer' type="submit">Create Account </button></div>
              </form>
              <div><p className='text-neutral-500'>have an account : <Link to="/login" className="text-blue-600 font-semibold">Login</Link></p></div>
            </div>
        </div>
      </div>
    </div>
  )
}
