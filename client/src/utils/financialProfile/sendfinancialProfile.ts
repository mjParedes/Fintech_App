import { TestData } from "@/components/modal/Onbording/steps/index";
import axios from "axios";
import Cookies from "js-cookie";
import assignProfileFinance from "@/lib/testOnbording";
const URL = "https://fintech-ggjf.onrender.com"

async function sendProfileFinance(test: TestData, userId: number): Promise<void> {
  try {
    const riskProfile = assignProfileFinance(test);

    const response = await axios.post(`${URL}/onboarding`, {
      userId,
      riskProfile,
    });

    const profileData = response.data;
    // console.log( "respuesta",profileData)

    return profileData;

  } catch (error) {
    console.error("Hubo un error al enviar el perfil al backend:", error);
  }
}

async function skipProfileFinance(): Promise<void> {
  const userLogged = JSON.parse(Cookies.get('userLogged') || '{}');
  const userId = userLogged.userId;

  try {
    const riskProfile= "SKIP";

    const response = await axios.post( `${URL}/onboarding`, {
      userId,
      riskProfile
    });

    // console.log(response)
    return response.data;
  } catch (error) {
    console.error("Hubo un error al enviar el perfil al backend:", error);
  }
} 

export {
    sendProfileFinance,
    skipProfileFinance
}