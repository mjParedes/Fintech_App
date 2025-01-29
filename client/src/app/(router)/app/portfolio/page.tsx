'use client'
import { ArrowBackIos, SettingsSuggest } from '@mui/icons-material'
import Link from 'next/link'
import React from 'react'
import InvestmentCard from './components/InvestmentCard'
import TimeChart from './components/TimeChart'

export default function Portfolio() {
	return (
		<main className="px-4 pt-6 pb-24 w-full h-min-screen text-white900">
			<div className='flex flex-col space-y-6'>

				{/* Header */}
				<div className='flex justify-between'>
					<div className='flex items-center'>
						<Link href={'/app/home'}>
							<ArrowBackIos />
						</Link>
						<h6 className='text-h6-bold ml-2'>Portafolio</h6>
					</div>
					<Link href={'/app/settings'}>
						<SettingsSuggest />
					</Link>
				</div>
				<div className='mx-auto'>
					<p className='text-p2-regular'>Ideal para desiciones estrategicas</p>
				</div>

				{/* Content Cards */}
				<InvestmentCard amount={10250.45} earning={871.29} />
				<TimeChart />




			</div>
		</main>
	)
}
