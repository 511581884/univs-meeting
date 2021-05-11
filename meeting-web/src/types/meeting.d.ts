import { Id } from ".";

// Meeting related types:
export interface Department {
  id: Id;
  name: string;
}

export interface Attendee {
  id: Id;
  department?: Department;
  name: string;
  isGuest?: boolean | number;
  phone?: string;
}

export type FileExtensionType = "doc" | "docx" | "xls" | "xlsx" | "ppt" | "pdf";

export interface File {
  id: Id;
  name: string;
  extension: FileExtensionType;
}
export interface Meeting {
  id: Id;
  attendees: Attendee[];
  endDate: Date;
  host: string;
  location: string;
  name: string;
  startDate: Date;
  files?: File[];
}

export interface Colleague {
  id: Id;
  name: string;
  department: Department;
}
