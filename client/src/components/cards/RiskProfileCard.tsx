import { useFinancialProfileStore } from "@/store/user/userFinanceProfile"
import Button from "../ui/Button"
import Image from "next/image"
import { Cazador, Explorador, Sembrador, WarningBlue } from "@/assets";

export const RiskProfileUser = () =>{

    const { financialProfile } = useFinancialProfileStore();
    let msg
    let img
    let goals
    let time

    if (financialProfile?.riskProfile === "Sembrador de oportunidades"){ img = Sembrador ; msg = "Priorizas la seguridad de tu capital y prefieres inversiones de bajo riesgo."; goals = "Crecimiento de corto plazo"; time="Máximo 2 años"}
    if (financialProfile?.riskProfile === "Explorador de nuevos caminos"){ img = Explorador ; msg = "Buscas inversiones de riesgo moderado y buen retorno." ; goals ="Crecimiento de mediano plazo";time ="2 - 5 años"}
    if (financialProfile?.riskProfile === "Cazador de inversiones"){ img = Cazador ; msg = "Buscas inversiones de riesgo moderado y buen retorno." ; goals = "Crecimiento de largo plazo"; time="Mínimo 5 añsos"}
    if (financialProfile?.riskProfile === "SKIP") {img=WarningBlue ; msg="Aun no haz realizado el Test del Inversor"; goals = "Sin identificar" ; time="Sin identificar"}

    return (
    <div className="border border-white200 p-2 rounded-lg ">
        <div className="flex flex-row gap-5 p-2">
            <div className="flex flex-col w-[50%] gap-1">
                <h1 className="text-h6-bold text-white900 ">{financialProfile?.riskProfile === "SKIP" ? "Test Omitido" : financialProfile?.riskProfile}</h1>
                <p className="text-p2-regular">{msg}</p>
            </div>
            <Image src={img} alt="" className="h-10 w-10 m-auto"/>
        </div>
        <div className="flex flex-col p-2 gap-2">
            <div className="flex flex-row justify-between">
                <h2 className="text-p1-bold text-white600 justify-end">Perfil de Riesgo</h2>
                <div>
                    <p className="text-p2-regular text-white900">{financialProfile?.riskProfile === "SKIP" ? "Sin identificar" : financialProfile?.riskProfile }</p>
                    <p className="text-p2-regular text-accent400">{financialProfile?.knowledgeLevel === "SKIP" ? "Sin identificar" : financialProfile?.knowledgeLevel}</p>
                </div>
            </div>
            <div className="flex flex-row justify-between">
                <h2 className="text-p1-bold text-white600">Metas de inversion</h2>
                <p className="text-p2-regular text-white900">{goals}</p>
            </div>
            <div className="flex flex-row justify-between">
                <h2 className="text-p1-bold text-white600">Plazo de inversión</h2>
                <p className="text-p2-regular text-white900">{time}</p>
            </div>
        </div>

        <div className="p-2 flex flex-col gap-3">
            <Button variant="solid" size="small" className="rounded-full">Ver más detalles</Button>
            <Button variant="basic" size="small" className="rounded-full">Test del Inversor</Button>
        </div>
    </div>)
}