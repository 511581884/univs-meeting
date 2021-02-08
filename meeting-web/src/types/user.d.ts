import { Id } from "."
import { Department } from "./meeting"

export interface User {
  id: Id;
  name: String;
  department: Department;
  avatarUrl: String;
}