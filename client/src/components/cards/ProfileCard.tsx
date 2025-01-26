import Image from "next/image"
import { useUserStore } from "@/store/user/userStore"
import { UserPhotoDefault } from "@/assets";

export const ProfileUser = () =>{

    const user = useUserStore((state) => state.user);
    let userPhoto 

    if(user.photoUrl === "string" || user.photoUrl == "") 
        { userPhoto = UserPhotoDefault
            } else{
            userPhoto = user.photoUrl
        }

    return (
        <>
            <div className="flex items-center justify-center p-2 ">
                <Image src={userPhoto } alt="" className="h-[7.5em] w-[7.5em]"/>
            </div> 

            <div className="flex flex-col p-1 ">
                <h1 className="text-h6-bold text-white900 text-center">{user.name} {user.lastName}</h1>
                <h2 className="text-p2-medium text-white900 text-center">  Invierte desde {new Date(user.registerDate).getFullYear()} </h2>
            </div>

            <div className="flex flex-col p-2">
                <div  className="flex flex-row justify-between py-1 px-3">
                    <h2 className="text-p2-bold text-white400 justify-end">Correo electrónico</h2>
                    <h2 className="text-p2-regular text-white400">{user.email}</h2>
                </div>
                <div className="flex flex-row justify-between px-3">
                    <h2 className="text-p2-bold text-white400 justify-end">Número de teléfono</h2>
                    <h2 className="text-p2-regular text-white400">{"+" + user.phoneNumber.toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1 ")}</h2>
                    </div>
            </div>
    </>
    )
}