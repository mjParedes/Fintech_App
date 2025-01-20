import Navbar from '@/components/layout/Navbar';
import React, { Children } from 'react';




const HomeLayout = ({ children }:{children: React.ReactNode}) => {
    return (
        <div>
            <Navbar/>
            {children}
        </div>
    );
};

export default HomeLayout;