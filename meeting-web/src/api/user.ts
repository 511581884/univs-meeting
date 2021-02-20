import { get } from "./http";
import { User } from "@/types"

const END_POINT = "api/user"

export const getUser = async()=>{
  const { data: user} = await get<User>(END_POINT,{
    requireAuth: true
  });
  return user
}