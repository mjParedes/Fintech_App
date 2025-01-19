const apiUrl = process.env.BASE_URL;

export  interface LoginUser {   
    email: string;
    password: string; 
}


export const fetchLoginUser = async (userData: LoginUser) => {

    try {
        const response = await fetch(`https://fintech-ggjf.onrender.com/auth/login`, {
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