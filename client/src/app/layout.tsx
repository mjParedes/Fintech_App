import type { Metadata } from "next";
import { Montserrat, Inter } from "next/font/google";
import "./globals.css";

const montserrat = Montserrat({
  subsets: ["latin"],
  variable: "--font-montserrat",
})

const inter = Inter({
  subsets: ["latin"],
  variable: "--font-inter",
})

export const metadata: Metadata = {
  title: "IUPI - save & invest wisely",
  description: "The best place to grow your money",
  keywords: "invest, save, money, growth, wealth",
  icons: {
    icon: [
      { rel: 'icon', url: '/favicon.ico', sizes: '16x16' },
    ],
  },
};

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html lang="es">
      <body
        className={`${montserrat.variable} ${inter.variable} antialiased`}
      >
        {children}
      </body>
    </html>
  );
}
