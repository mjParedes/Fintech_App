"use client";

import { BookIcon, BookImg, EducationActiveLarge, SkipUser } from "@/assets";
import useGameStore from "@/store/community/gameEducation";
import Image from "next/image";
import Button from "@/components/ui/Button";
import { useState, useEffect } from "react";
import { useParams } from "next/navigation"; 
import { redirect } from "next/navigation";
import { GameProgressBar } from "@/components/progressBar/communityBar";
import { Close } from "@mui/icons-material";
import CheckCircleRoundedIcon from '@mui/icons-material/CheckCircleRounded';
import { green } from "@mui/material/colors";

export default function GameEducation() {
  const params = useParams(); 
  const [id, setId] = useState<number>(0);
  const games = useGameStore((state) => state.games);
  const gameSelect = games ? games[id] : null;
  const [answer, setAnswer] = useState<number | null>(null);
  const [optionSelect, setOptionSelect] = useState<{ value: string; description: string } | null>(null);
  const [stage, setStage] = useState(0);

  useEffect(() => {
    if (params.id) {
      setId(Number(params.id)); 
    }
    
    if (stage === 0) {
      const timer = setTimeout(() => {
        setStage(1);
      }, 3000);
      return () => clearTimeout(timer);
    }

    if (stage === 2) {
      const timer = setTimeout(() => {
        setStage(3);
      }, 3000);
      return () => clearTimeout(timer);
    }

    if (stage === 3) {
      const timer = setTimeout(() => {
        setStage(4);
      }, 3000);
      return () => clearTimeout(timer);
    }
  }, [stage, params.id]); 

  const handleCommunity = () => {
    redirect("/app/community");
  };


  return (
    <div >
      <div>
        <Image src={EducationActiveLarge} alt="" className="p-4 mx-auto" />
        
        {stage === 0 && (
          <div className="flex flex-col">
          <div className="flex flex-col gap-5 bg-primary100 h-[35.25em] w-[25em] mx-auto p-2 rounded-2xl items-center justify-center">
              <Image src={BookImg} alt="" className="" />
              <h1 className="text-p1-bold text-white900 w-[30vh] text-center ">
                ¿Sabías que Stocks y Acciones significan lo mismo?
              </h1>
            </div>
              <Image src={BookIcon} alt="" className="mt-[-10em] ml-20 w-[18em]"  />
          </div>
        )}

        {stage === 1 && (
          <> { !gameSelect 
            ?
              <div className="modal-background">
                <div className="modal-content">
                  <Image src={SkipUser} alt="" />
                  <h1>Proximamente encontrarás más niveles!</h1>
                  <Button onClick={handleCommunity} variant="solid" size="small" className="rounded w-[25em]">
                    Cerrar
                  </Button>
                </div>
              </div>

          : <div>

            <div className="flex flex-col p-3 h-[35em] w-[25em] mx-auto  bg-primary100 rounded-2xl">
              <Image src={BookImg} alt=" m-1 p-3" />
              <div className="p-8">
                <GameProgressBar currentStep={1} totalSteps={2} />
              </div>
              <h1 className="text-h6-semibold text-white900 p-6 pt-8 text-center w-[18em] mx-auto">{gameSelect.question}</h1>
              <div className="grid grid-cols-2 grid-rows-2 gap-4">
                {gameSelect.options.map((opt: { value: string; description: string }, index: number) => (
                  <button
                    key={index}
                    onClick={() => {
                      setAnswer(index + 1);
                      setOptionSelect(opt);
                      setStage(2);
                    }}
                    className="bg-white text-white700 text-p1-bold items-center p-2 rounded-2xl"
                  >
                    {opt.value}
                  </button>
                ))}
              </div>
              <Image src={BookIcon} alt="" className="mt-[-1em] ml-20 w-[18em]"  />
            </div>
          </div>
          }
          </>
        )}

        {stage === 2 && (
          <div className="flex flex-col">
            <div className="p-4 h-[35em] w-[25em] mx-auto  bg-primary100 rounded-2xl ">
              <div className="h-[5em]">
              {answer ===
            (gameSelect && gameSelect.options
              ? gameSelect.options.findIndex((opt) => opt.value === gameSelect.answer) + 1
              : -1)
              ? <CheckCircleRoundedIcon  sx={{ fontSize: 50 , color:green[400]}}/>
              : <Close color="error" sx={{ fontSize: 50 }}/>
              }
              </div>
              <h1 className="text-h6-semibold text-white900 h-[5em]">{optionSelect?.value}</h1>
              <p className="h-[15vh]">{optionSelect?.description}</p>
            </div>
            <Image src={BookIcon} alt="" className="mt-[-10em] ml-20 w-[18em]"  />
          </div>
        )}

        {stage === 3 && 
        <div>
            <div className="flex flex-col gap-5 bg-primary100 h-[35.25em] w-[25em] mx-auto p-2 rounded-2xl items-center justify-center">
              <Image src={BookImg} alt="" className="" />
              <h1 className="text-p1-bold text-white900 w-[40vh] text-center ">
              Cada bit de conocimiento que adquieras te acerca más a la libertad financiera.
              </h1>
            </div>
              <Image src={BookIcon} alt="" className="mt-[-10em] ml-[13em] w-[18em]"  />
          </div>
          }

        {stage === 4 && (
          <div>
            <div></div>
            <p>
          {answer === (gameSelect?.options?.findIndex((opt: { value: string; description: string }) => opt.value === gameSelect?.answer) ?? -2) + 1
            ? "¡Felicidades, has ganado!"
            : "Mejor suerte la próxima vez."}
        </p>

            <Button onClick={handleCommunity} variant="solid" size="small" className="rounded w-[25em]">
              Cerrar
            </Button>
          </div>
        )}
      </div>
    </div>
  );
}
