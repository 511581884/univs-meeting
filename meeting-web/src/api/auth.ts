import { get } from "./http";

const END_POINT = "/api/auth";

export const fetchToken = async () => {
  const { data: token } = await get<string>(END_POINT);
  return token;
};

export const setToken = (token: string) => {
  localStorage.setItem("x-auth-token", token);
};

export const getToken = (): string | null => {
  return localStorage.getItem("x-auth-token");
};
