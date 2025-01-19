const apiUrl = process.env.BASE_URL;

export  interface registerUser {   
    photoUrl: string;
    name: string;
    lastName: string;
    email: string;
    password: string;
    phoneNumber: number;
    birthDate: string;
    roleDto: {
        roles: string[];
    }; 
}


export const fetchRegisterUser = async (userData: registerUser) => {

    try {
        const response = await fetch(`https://fintech-ggjf.onrender.com/auth/register`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(userData),
        });
        //console.log(response);

        if (!response.ok) {
            throw new Error('Network response was not ok');
        }

        const data = await response.json();
        
        return data;
    } catch (error) {
        console.error('There was a problem with the fetch operation:', error);
        throw error;
    }
};

