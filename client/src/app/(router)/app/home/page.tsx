"use client"
import BalanceCard from "@/components/cards/BalanceCard";
import GoalCard from "@/components/cards/GoalCard";
import { useEffect} from 'react';
import RecommendationCard from '@/components/cards/RecommendationCard';
import getUserProfile from '@/utils/financialProfile/getProfile';
import Onbording from '@/components/modal/Onbording/onbording';
import FinancialSampleCard from '@/components/cards/FinancialSampleCard';
import getUserData from "@/utils/getUserData";
import { useModalStore } from "@/store/onBording/modal";
import marketStore from "@/store/market/dataMarket";
import { getPortfolios } from "@/utils/portfoil/getPortfoil";

export default function Home() {
  const { modalState, openModal, closeModal } = useModalStore();
  const loadAllVariablesData = marketStore((state) => state.loadAllVariablesData);

  useEffect(() => {
    const fetchProfile = async () => {
      const { profileData } = await getUserProfile();
      
      if (!profileData && modalState !== "Abierto") {
        openModal();
      } else {
        closeModal();
      }
    };
    loadAllVariablesData();
    getPortfolios()
  
    fetchProfile();
    getUserData(); 
  }, [modalState]); 
  

  const userGoals = [
    {
      title: "Mi propia casa en el interior",
      amount: 5000000,
      mode: 'saving'
    },
    {
      title: "Viaje a Japon con millas",
      amount: 250000,
      mode: 'pleasure'
    },
    {
      title: "Comprar un automovil",
      amount: 1000000,
      mode: 'buying'
    }
  ];

  const recommendations = [
    {
      label: 'Fondo de Crecimiento en Tecnología',
      description: 'Basado en tu perfil de inversor.',
      percentage: 9.2
    },
    {
      label: 'Energía verde ETF',
      description: 'Tendencia en tu grupo de edad.',
      percentage: 5.7
    },
    {
      label: 'Fondo de Bonos Corporativos',
      description: 'Diversifica tu cartera.',
      percentage: 4.3
    },
    {
      label: 'Fondo de Startups',
      description: 'Participa en empresas emergentes.',
      percentage: 15.0
    }
  ]

  const financialData = [
    {
      title: 'Ingresos',
      icon: '/img/MoneyBag.png',
      value: 12545.59,
      path: '/details/incomes'
    },
    {
      title: 'Gastos',
      icon: '/img/MoneyWings.png',
      value: 10750.9,
      path: '/details/expenses'
    },
    {
      title: 'Capacidad de ahorro',
      icon: '/img/ClappingHands.png',
      value: 14.3,
      path: '/details/savings'
    },
    {
      title: 'Total de deudas',
      icon: '/img/FlagInHole.png',
      value: 50000,
      path: '/details/debts'
    }
  ]


  return (
    <main className="px-4 pt-6 pb-24 space-y-4 w-full bg-primary300">
      {modalState === "Abierto" && <Onbording />}
      <BalanceCard title="Tus rendimientos" amount={10250.45} earning={871.29} />

      {/* Financial samples */}
      <div className='flex flex-wrap gap-4 lg:w-[90%] lg:mx-auto'>
        {financialData.map((data, index) => (
          <FinancialSampleCard
            key={index}
            title={data.title}
            icon={data.icon}
            value={data.value}
            path={data.path}
          />
        )
        )}
      </div>

      <GoalCard goals={userGoals} />
      <RecommendationCard title="Recomendado para ti" items={recommendations} />
    </main>
  );
}
