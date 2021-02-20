import axios, { AxiosRequestConfig } from "axios";
import { getToken } from "./auth";

export interface HttpRequestConfig {
  requireAuth: boolean;
  params?: {
    [index: string]: string;
  };
  payload?: {
    [index: string]: any;
  };
}

const BASE_URL = process.env.VUE_APP_BACKEND_URL;

const http = axios.create({
  baseURL: BASE_URL,
});

export function get<R>(endPoint: string, config?: HttpRequestConfig) {
  const options: AxiosRequestConfig = {
    headers: {},
    params: config && config.params,
  };

  if (config && config.requireAuth) {
    options.headers["x-auth-token"] = getToken();
  }

  return http.get<R>(endPoint, options);
}

export function post<R>(endPoint: string, config?: HttpRequestConfig) {
  const payload = config && config.payload;

  const options: AxiosRequestConfig = {
    headers: {},
    params: config && config.params,
  };

  if (config && config.requireAuth) {
    options.headers["x-auth-token"] = getToken();
  }

  return http.post<R>(endPoint, payload, options);
}
