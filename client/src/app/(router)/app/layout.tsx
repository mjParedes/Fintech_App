
import isUserLogged from '@/utils/isUserLogged';
import React from 'react';


const AccountLayout: React.FC<{ children: React.ReactNode }> = async ({ children }) => {

    const token = await isUserLogged();
    console.log(token);

    return (
        <div className=''>
            {children}
        </div>
    );
};

export default AccountLayout;