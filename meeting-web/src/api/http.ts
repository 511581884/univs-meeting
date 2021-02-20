import axios, { AxiosRequestConfig } from "axios";
import { getToken } from "./auth";

const BASE_URL = "http://localhost:3002";

export interface HttpRequestConfig<P> {
  requireAuth: boolean;
  params?: {
    [index: string]: string;
  };
  payload?: P;
}

const http = axios.create({
  baseURL: BASE_URL,
});

export function get<P>(endPoint: string, config?: HttpRequestConfig<P>) {
  const { params, requireAuth } = config;

  const options: AxiosRequestConfig = {
    params,
  };

  if (requireAuth) {
    options.headers["x-auth-token"] = getToken();
  }

  return http.get<P>(endPoint, options);
}

export function post<P>(endPoint: string, config?: HttpRequestConfig<P>) {
  const { params, payload, requireAuth } = config;

  const options: AxiosRequestConfig = {
    params,
  };

  if (requireAuth) {
    options.headers["x-auth-token"] = getToken();
  }

  return http.post<P>(endPoint, payload, options);
}
