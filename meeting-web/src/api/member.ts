import { Colleague, Id } from "@/types";
import { get } from "./http";

const END_POINT = "/api/members";

export const getColleague = async () => {
  const { data: colleague } = await get<Colleague[]>(END_POINT, {
    requireAuth: true,
  });

  return colleague;
};
