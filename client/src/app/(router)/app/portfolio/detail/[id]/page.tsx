'use client';
import { ArrowLargeLeft } from "@/assets";
import Button from "@/components/ui/Button";
import Image from "next/image";
import Link from "next/link";
import { useParams } from "next/navigation";
import { useState , useEffect} from "react";
import marketStore from "@/store/market/dataMarket";
import { GeneralInformationInstrument } from "@/components/cards/GeneralInformation";
import { PerformanceInstrument } from "@/components/cards/PerformanceIntrument";


export default function DetailInstruments () {
    const loadAllVariablesData = marketStore((state) => state.loadAllVariablesData);
      const params = useParams();
      const [id, setId] = useState<string>("");
      const bonos = marketStore((state)=>state.bonos)
      const actions = marketStore((state)=>state.cedears)

      const market = [bonos,actions]

      useEffect(() => {
          if (params.id) setId(String(params.id));
          loadAllVariablesData();
      },[params.id])

      const handleBack = () =>{

      }

    return(
    <main className="flex flex-col p-4">
        <section className="flex flex-col p-4 justify-center ">
            <div onClick={handleBack} className="flex flex-row gap-3">
            <Image src={ArrowLargeLeft} alt=""/>
            <h1 className="text-h6-bold text-900 p-2">{id}</h1>
            </div>
            <p className="text-p2-regular text-white700 p-2">Aqui encontraras más detalles sobre el instrumento seleccionado</p>
        </section>
        <section className="flex w-full m-auto">
            <GeneralInformationInstrument id={id} market={market}/>
        </section>
        <section className="flex w-full m-auto">
            <PerformanceInstrument id={id} market={market}/>
        </section>
        <Button variant="solid" size="medium">Invertir</Button>
        <div className="flex flex-row justify-between">
            <Button>Guardar</Button>
            <Link href="/community"><Button>Comunidad</Button></Link>
        </div>
    </main>
    )
}