
import { cookies } from 'next/headers';

const isUserLogged = async () => {
    const token =  (await cookies()).get('userLogged')?.value;
    return token;
};

export default isUserLogged;