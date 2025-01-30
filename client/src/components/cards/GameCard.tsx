import { BookIcon, BookImg, educationActive, SkipUser } from "@/assets";
import useGameStore from "@/store/community/gameEducation";
import Image from "next/image";
import Button from "../ui/Button";
import { useState, useEffect } from "react";

type GameCardProps = {
  id: number; 
  onClose: () => void; 
};

export const GameCard: React.FC<GameCardProps> = ({ id, onClose }) => {
  const game = useGameStore((state) => state.games[id]); 
  const [answer, setAnswer] = useState<number | null>(null);
  const [optionSelect , setOptionSelect] = useState("")
  // Crear estado para que guarde la data de answer y seguir el flujo
  const [stage, setStage] = useState(0); 

  useEffect(() => {
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

  }, [stage]); 

  const handleSendAnswer = (selectedAnswer: number) => {
    setAnswer(selectedAnswer); 
    setStage(2); 
  };

  if (!game) {
    return (
      <div className="modal-background">
        <div className="modal-content">
          <Image src={SkipUser} alt="" />
          <h1>Proximamente encontraras más niveles!</h1>
          <Button onClick={onClose} variant="solid" size="small" className="rounded w-[25em]">Cerrar</Button>
        </div>
      </div>
    );
  }

  return (
    <div className="modal-background">
      <div className="modal-content">
        {stage === 0 && (
        <div>
            <Image src={educationActive} alt="" className="p-4"></Image>
            <div className="flex flex-col bg-primary100">
                <Image src={BookImg} alt="" className="items-center justify-center"/>
                <h1 className="text-p1-bold text-white900 w-[50vh] items-center justify-center">¿Sabías que Stocks y Acciones significan lo mismo?</h1>
                <Image src={BookIcon} alt=""/>
            </div>
          </div>
        )}

        {stage === 1 && (
        <div>
            <Image src={educationActive} alt="" className="p-4"></Image>
            <div className="flex flex-col p-2">
                <Image src={BookImg} alt=""></Image>
                <p>ProgressBar</p>
                <h1 className="text-h6-semibold text-white900">{game.question}</h1>
                <div className="grid grid-cols-2 grid-rows-2 gap-4">
                {game.options.map((option, index) => (
                    <button
                    key={index}
                    onClick={() => handleSendAnswer(index + 1)}
                    className="bg-white text-white700 text-p1-bold items-center p-2"
                    >
                    {option.value}
                    </button>
                ))}
                </div>
            </div>
          </div>
        )}

        {stage === 2 && (
          <div>
            <div>
            <h1 className="">
              {answer === game.options.findIndex((opt) => opt.value === game.answer) + 1
                ? "✅​​"
                : "❌​​"}
            </h1>
            <h1 className="text-h6-semibold text-white900">{game.}</h1>
            <p className=""></p>

          </div>
          </div>
        )}

        {stage === 3 && <h1>Guardando resultado...</h1>}

        {stage === 4 && (
          <div>
            <h1>¡Resultado Final!</h1>
            <p>
              {answer === game.options.findIndex((opt) => opt.value === game.answer) + 1
                ? "¡Felicidades, has ganado!"
                : "Mejor suerte la próxima vez."}
            </p>
            <Button onClick={onClose} variant="solid" size="small" className="rounded w-[25em]">Cerrar</Button>
          </div>
        )}

       
      </div>
    </div>
  );
};
