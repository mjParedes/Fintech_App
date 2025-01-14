'use client';
import React, { useState, useEffect } from 'react';
import Image from 'next/image';


import { useFormik } from 'formik';
import * as Yup from 'yup';
import { useRouter } from 'next/navigation'
import Loader from '../../../../components/Loader';
import Link from 'next/link';
import { FaEye } from "react-icons/fa";
import { FaEyeSlash } from "react-icons/fa";

import Swal from 'sweetalert2';
import Cookies from 'js-cookie';

export default function LoginForm() {
  const [showForm, setShowForm] = useState(false);
  const [loading, setLoading] = useState(false);
  const [rememberMe, setRememberMe] = useState(false);
  const [showPassword, setShowPassword] = useState(false);
  const router = useRouter();
  
  
  useEffect(() => {
    const timer = setTimeout(() => {
      setShowForm(true);
    }, 1000);
    return () => clearTimeout(timer);
  }, []);

  const validationSchema = Yup.object({
    email: Yup.string()
      .email('Ingrese un email válido')
      .required('El email es requerido'),
    pass: Yup.string()
      .min(8, 'La contraseña debe tener al menos  8 caracteres')
      .max(15,"la contraseña debe ser igual o menor a 12 caracteres")
      .required('La contraseña es requerida'),
  });

  const formik = useFormik({
    initialValues:{ 
      email: Cookies.get("userEmail") || "",
      pass: "",
    },
    validationSchema,
    onSubmit: async  (values, {resetForm}) => {
      if (rememberMe) {
        Cookies.set('userEmail', values.email, {
          secure: true,
          sameSite: 'strict',
          expires: 7, // Duración de la cookie en días
        });
      }
      setLoading(true);
      {/*
        if(response.success == true){
        Swal.fire({
          icon: "success",
          title: `${response.message}`,
          showConfirmButton: false,
          timer: 2500
        });
        setLoading(false)
        resetForm();
        
        //luego tocaria la redireccion, pero aun falta
      }

      if(response.success == false){
        Swal.fire({
          icon: "error",
          title: `${response.message}`,
          showConfirmButton: false,
          timer: 2500
        });
        setLoading(false)
        resetForm();
      }
        */}
      
      
    },
  });

  return (
    <section className='flex items-center justify-center h-screen'>
      
      {showForm && (
        <form
          onSubmit={formik.handleSubmit}
          className='bg-black text-white p-4 sm:p-6 md:p-8 lg:p-10'
        >
          {loading ? (
            <Loader />
          ) : (
            <>
              
              <h2 className='mb-6'>Inicia Sesión</h2>


              <label htmlFor='email' className='mb-2 mt-2'>
                Correo Electrónico
              </label>
              <div className='relative mt-2 mb-2'>
                <input
                  type='email'
                  id='email'
                  placeholder='Correo electronico'
                  className={`text-primaryDefault bg-gray-800   border-2  text-sm rounded-lg  block w-full p-2.5 pl-9  dark:bg-gray-700 dark:placeholder-gray-100 dark:text-white  ${formik.touched.email && formik.errors.email ? 'border-red-500 focus:ring-red-500 focus:border-red-500'  :  formik.touched.email && formik.values.email  ? 'border-green-500 focus:ring-green-500 focus:border-green-500' : formik.values.email ? 'border-green-500 focus:ring-green-500 focus:border-green-500' :   'border-gray-700 focus:ring-gray-700 focus:border-gray-700'}`}
                  onChange={formik.handleChange}
                  value={formik.values.email}
                />
                {formik.touched.email && formik.errors.email ? (
                  <div className='my-1 text-primaryDefault'>{String(formik.errors.email)}</div>
                ) : null}
                  
                </div>

              <label htmlFor='pass' className='mb-2 mt-2'>
                Contraseña
              </label>
              
              <div className='relative mt-2 mb-2'>
                <input
                  type={showPassword ? 'text' : 'password'} // Cambia el tipo del input
                  id='pass'
                  name='pass'
                  placeholder='Contraseña'
                  className={`text-primaryDefault bg-gray-800   border-2  text-sm rounded-lg  block w-full p-2.5 pl-9  dark:bg-gray-700 dark:placeholder-gray-100 dark:text-white  ${formik.touched.pass && formik.errors.pass ? 'border-red-500 focus:ring-red-500 focus:border-red-500'  :  formik.touched.pass && formik.values.pass  ? 'border-green-500 focus:ring-green-500 focus:border-green-500' : formik.values.pass ? 'border-green-500 focus:ring-green-500 focus:border-green-500' :   'border-gray-700 focus:ring-gray-700 focus:border-gray-700'}`}
                  //className='text-primaryDefault bg-gray-800 mb-2 p-2 border-none rounded-lg w-full pl-10 border border-gray-300'
                  onChange={formik.handleChange}
                  value={formik.values.pass}
                />
                {formik.touched.pass && formik.errors.pass ? (
                  <div className='my-1 text-primaryDefault'>{String(formik.errors.pass)}</div>
                ) : null}
                <div className='absolute left-[10px] top-[22px] transform -translate-y-1/2'>
                  <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" strokeWidth="1.5" stroke="currentColor" className="w-5 h-5 text-primaryDefault">
                    <path strokeLinecap="round" strokeLinejoin="round" d="M16.5 10.5V6.75a4.5 4.5 0 1 0-9 0v3.75m-.75 11.25h10.5a2.25 2.25 0 0 0 2.25-2.25v-6.75a2.25 2.25 0 0 0-2.25-2.25H6.75a2.25 2.25 0 0 0-2.25 2.25v6.75a2.25 2.25 0 0 0 2.25 2.25Z" />
                  </svg>
                </div>

                <div
                  className="absolute right-[10px] top-[22px] transform -translate-y-1/2 cursor-pointer"
                  onClick={() => setShowPassword((prev) => !prev)}
                >
                  {showPassword ? (
                    // Ícono para ocultar contraseña
                    <FaEye className='text-primaryDefault' />
                  ) : (
                    // Ícono para mostrar contraseña
                    <FaEyeSlash className='text-primaryDefault' />
                  )}  
                </div>
                </div>
              
              <div className='flex justify-between items-center mb-4'>
                <div className='flex items-center mb-4'>
                  <input
                    type='checkbox'
                    id='remember'
                    className='form-checkbox mr-2 text-gray700'
                    onChange={()=>{setRememberMe(!rememberMe)}}
                    checked={rememberMe}
                  />
                  <label htmlFor='remember'>Recordarme</label>
                </div>

                <p className='mb-4 ml-3 no-underline text-primaryLigth'>
                  Recuperar contraseña
                </p>
              </div>
              <button
                type='submit'
                className='p-2 bg-primaryDefault text-white rounded-md w-full '
              >
                Confirmar
              </button>
              <h2 className='text-gray-500 mt-4'>
                No estas registrado? 
                <Link href={"/registro"} > <span className='text-primaryLigth '> Crear Cuenta</span></Link>
              </h2>
            </>
          )}
        </form>
      )}
    </section>
  );
}