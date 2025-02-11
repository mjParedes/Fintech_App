'use client'
import Link from 'next/link'
import { ArrowBackIos } from '@mui/icons-material'
import GoalForm from './components/GoalForm'


export default function Goals() {

	return (
		<main className="flex flex-col justify-start px-4 pt-6 w-full min-h-screen  text-white900">
			<div className='flex justify-between'>
				<div className='flex items-center'>
					<Link href={'/app/home'}>
						<ArrowBackIos />
					</Link>
					<h6 className='text-h6-bold ml-2'>Nueva meta</h6>
				</div>
			</div>
			<div className='max-w-md p-6'>
				<h5 className='text-h5-semibold mb-4'>Define tus metas</h5>
				<p className='text-p2-regular mb-6'>Define algunos datos importantes para identificar claramente tus metas:</p>
			</div>

			<GoalForm />

		</main>
	)
}

