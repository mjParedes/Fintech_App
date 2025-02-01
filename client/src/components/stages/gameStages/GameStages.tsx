import Image from "next/image";
import { Close } from "@mui/icons-material";
import CheckCircleRoundedIcon from '@mui/icons-material/CheckCircleRounded';
import { green } from "@mui/material/colors";
import { BookImg, BookIcon, SkipUser, SuccessGame, CrownOn, PointsIcon, ShieldOn } from "@/assets";
import Button from "@/components/ui/Button";
import { GameProgressBar } from "@/components/progressBar/communityBar";
import { redirect } from "next/navigation";

interface GameOption {
  value: string;
  description: string;
}

interface GameSelect {
  question: string;
  options: GameOption[];
  answer: string;
}

export function IntroStage() {
  return (
    <div className="flex flex-col">
      <div className="flex flex-col gap-5 bg-primary100 h-[35.25em] w-[25em] mx-auto p-2 rounded-2xl items-center justify-center shadow-lg">
        <Image src={BookImg} alt="" />
        <h1 className="text-p1-bold text-white900 w-[30vh] text-center">
          ¿Sabías que Stocks y Acciones significan lo mismo?
        </h1>
      </div>
      <Image src={BookIcon} alt="" className="mt-[-10em] ml-20 w-[18em]" />
    </div>
  );
}

interface QuestionStageProps {
    gameSelect: GameSelect | null;
    setAnswer: (answer: number) => void;
    setOptionSelect: (option: GameOption) => void;
    setStage: (stage: number) => void;
    onSelectAnswer: (index: number, option: { value: string; description: string }) => void; // Aquí
  }  

export function QuestionStage({ gameSelect, setAnswer, setOptionSelect, setStage }: QuestionStageProps) {
  const handleCommunity = () => {
    redirect("/app/community");
  };

  if (!gameSelect) {
    return (
      <div className="modal-background">
        <div className="modal-content">
          <Image src={SkipUser} alt="" />
          <h1>Próximamente encontrarás más niveles!</h1>
          <Button onClick={handleCommunity} variant="solid" size="small" className="rounded w-[25em]">
            Cerrar
          </Button>
        </div>
      </div>
    );
  }

  return (
    <div>
      <div className="flex flex-col p-3 h-[35em] w-[25em] mx-auto bg-primary100 rounded-2xl shadow-lg">
        <Image src={BookImg} alt=" m-1 p-3" />
        <div className="p-8">
          <GameProgressBar currentStep={1} totalSteps={2} />
        </div>
        <h1 className="text-h6-semibold text-white900 p-6 pt-8 text-center w-[18em] mx-auto">{gameSelect.question}</h1>
        <div className="grid grid-cols-2 grid-rows-2 gap-4">
          {gameSelect.options.map((opt, index) => (
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
        <Image src={BookIcon} alt="" className="mt-[-1em] ml-20 w-[18em]" />
      </div>
    </div>
  );
}

interface AnswerFeedbackStageProps {
  gameSelect: GameSelect;
  answer: number;
  optionSelect: GameOption | null;
}

export function AnswerFeedbackStage({ gameSelect, answer, optionSelect }: AnswerFeedbackStageProps) {
  return (
    <div className="flex flex-col">
      <div className="p-4 h-[35em] w-[25em] mx-auto bg-primary100 shadow-lg rounded-2xl">
        <div className="h-[5em]">
          {answer === gameSelect.options.findIndex((opt) => opt.value === gameSelect.answer) + 1 ? (
            <CheckCircleRoundedIcon sx={{ fontSize: 50, color: green[400] }} />
          ) : (
            <Close color="error" sx={{ fontSize: 50 }} />
          )}
        </div>
        <h1 className="text-h6-semibold text-white900 h-[5em]">{optionSelect?.value}</h1>
        <p className="h-[15vh]">{optionSelect?.description}</p>
      </div>
      <Image src={BookIcon} alt="" className="mt-[-10em] ml-20 w-[18em]" />
    </div>
  );
}

export function KnowledgeStage() {
  return (
    <div>
      <div className="flex flex-col gap-5 bg-primary100 h-[35.25em] w-[25em] mx-auto p-2 rounded-2xl items-center justify-center shadow-lg">
        <Image src={BookImg} alt="" />
        <h1 className="text-p1-bold text-white900 w-[40vh] text-center">
          Cada bit de conocimiento que adquieras te acerca más a la libertad financiera.
        </h1>
      </div>
      <Image src={BookIcon} alt="" className="mt-[-10em] ml-[13em] w-[18em]" />
    </div>
  );
}

interface ResultStageProps {
  gameSelect: GameSelect;
  answer: number;
}

export function ResultStage({ gameSelect, answer }: ResultStageProps) {
  return (
    <div>
      {answer === gameSelect.options.findIndex((opt) => opt.value === gameSelect.answer) + 1 ? (
        <div className="flex flex-col p-3 h-[35em] w-[25em] mx-auto bg-primary100 rounded-2xl items-center justify-center shadow-lg">
          <Image src={SuccessGame} alt="" className="justify-center" />
          <h1 className="text-white900 text-h6-semibold text-center p-4">
            ¡Felicidades por alcanzar el primer nivel de tu viaje de inversión!
          </h1>
          <div className="flex flex-row gap-3 p-2">
            <div className="flex flex-row bg-primary50 rounded-lg shadow-lg w-[7em] h-[4.5em] items-center justify-center gap-1">
              <Image src={CrownOn} alt="Ranking" />
              <h2 className="text-white500 text-p1-semibold">10</h2>
            </div>
            <div className="flex flex-row bg-primary50 rounded-lg shadow-lg w-[7em] h-[4.5em] items-center justify-center gap-1">
              <Image src={PointsIcon} alt="Puntos ganados" />
              <h2 className="text-white500 text-p1-semibold">+ 85</h2>
            </div>
            <div className="flex flex-row bg-primary50 rounded-lg shadow-lg w-[7em] h-[4.5em] items-center justify-center gap-1">
              <Image src={ShieldOn} alt="Divisiones" />
              <h2 className="text-white500 text-p1-semibold">Estrellas</h2>
            </div>
          </div>
            <div className="bg-primary50 rounded-lg p-1 shadow-lg w-full">
                <h2 className="text-p1-regular text-center w-[30vh] mx-auto text-white700" >Puedes usar tus puntos ganados en el FCI de iUpi.</h2>
            </div>
        </div>
      ) : (
        <div>perdedor</div>
      )}
    </div>
  );
}
