import { useUserStore } from "@/store/user/userStore";
import Cookies from "js-cookie";
import axios from 'axios';

const URL = "https://fintech-ggjf.onrender.com"

export const getUserData = async () => {
  const userLogged = JSON.parse(Cookies.get('userLogged') || '{}');
  const userId = userLogged.userId;

  try {
    const userResponse = await axios.get(`${URL}/user/${userId}`);
    const userData = userResponse.data;

    console.log("traigo la info del user",userData)

    const { setUser } = useUserStore.getState();
    setUser({
      id: userId,
      name: userData.name,
      lastName: userData.lastName,
      email: userData.email,
      photoUrl: userData.photoUrl,
      phoneNumber: userData.phoneNumber,
      birthDate: userData.birthDate,
      roles: userData.roles,
    });

    return { userData };

  } catch (error) {
    console.error('Error en la solicitud al backend:', error);
  }
};

export default getUserData;
