import Image from 'next/image';
import React from 'react';
import logo from "../../../../public/Logo azul completo.png"
import Link from 'next/link';

const AccountLayout: React.FC<{ children: React.ReactNode }> = ({ children }) => {
    return (
        <div className='w-full h-auto bg-white pt-10 px-4'>
            <div className='flex justify-center items-center flex-col'>
                <Image src={logo} alt='Logo' width={200} height={200} />
            </div>
            
            <main>
                {children}
            </main>
            


            <footer className='flex  justify-between p-4 border-t mt-10 w-full '>
                <p className='text-sm'>© 2025 iUpi. <br/>Todos los derechos reservados.</p>
                <div className=''>
                    <p>
                    <Link href='/' className='text-sm text-start'>Términos y condiciones</Link>
                    </p>

                    <p>
                    <Link href='/' className='text-sm'>Política de privacidad</Link>
                    </p>
                </div>
            </footer>
        </div>
    );
};

export default AccountLayout;