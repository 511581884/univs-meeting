// Meeting related types:
export interface Department {
  id: number;
  name: string;
}

export interface Attendee {
  id: number;
  department: Department;
  name: string;
  isGuest: boolean | number;
  phone: string;
}

export interface Meeting {
  id: number;
  attendees: Attendee[];
  endDate: Date;
  host: string;
  location: string;
  name: string;
  startDate: Date;
}

//notification related type:
export enum NotificationType {
  "cancel",
  "change",
  "reassign",
  "remind",
}

export interface Notification {
  id: number;
  location: string;
  createDate: Date;
  hasRead: boolean;
  meetingName: string;
  type: NotificationType;
  startDate?: Date;
}

export interface ReassignNotification extends Notification {
  requester: string;
}

export interface ChangeNotification extends Notification {
  originalDate: Date;
  originalLocation: string;
  currentDate: Date;
  currentLocation: string;
}
