import { Meeting } from "@/types";
import { get } from "./http";

const END_POINT = "/api/meetings";

export const getMeetings = async () => {
  const { data: meetings } = await get<Meeting[]>(END_POINT, {
    requireAuth: true,
  });

  return meetings;
};
