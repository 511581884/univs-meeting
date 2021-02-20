import axios, { AxiosRequestConfig } from "axios";
import { getToken } from "./auth";

const BASE_URL = process.env.VUE_APP_BACKEND_URL;

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
  // extract the individual parameters

  const options: AxiosRequestConfig = {
    headers: {},
    params: config && config.params,
  };

  if (config && config.requireAuth) {
    options.headers["x-auth-token"] = getToken();
  }

  return http.get<P>(endPoint, options);
}

export function post<P>(endPoint: string, config?: HttpRequestConfig<P>) {
  const payload = config && config.payload;

  const options: AxiosRequestConfig = {
    headers: {},

    params: config && config.params,
  };

  if (config && config.requireAuth) {
    options.headers["x-auth-token"] = getToken();
  }

  return http.post<P>(endPoint, payload, options);
}
