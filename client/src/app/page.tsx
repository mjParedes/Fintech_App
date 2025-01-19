"use client"
import { useEffect } from "react";
import { useRouter } from "next/navigation";
import Dashboard from "@/components/layout/Dashboard";
import BalanceCard from "@/components/cards/BalanceCard";
import GoalCard from "@/components/cards/GoalCard";

export default function Home() {
  const router = useRouter();

  const userGoals = [
    {
      title: "Viaje a Japon con millas",
      amount: 250000,
      percentage: 50,
    },
    {
      title: "Mi propia casa en el interior",
      amount: 5000000,
      percentage: 30
    },
  ]

  // useEffect(() => {
  //   const timer = setTimeout(() => {
  //     router.push("/account/register");
  //   }, 3000);

  //   return () => clearTimeout(timer);
  // }, [router]);

  return (
    <main>
      <section className="px-4 pt-6 space-y-4 w-full bg-primary300 h-screen">
        <BalanceCard amount={0.00} />
        <GoalCard goals={userGoals} />

        <Dashboard />
      </section>
    </main>
  );
}
