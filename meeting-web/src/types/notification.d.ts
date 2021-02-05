import { Id } from ".";

//notification related type:
export type NotificationType =
  | CancelNotification
  | RemindNotification
  | ReassignNotification
  | ChangeNotification;

export interface Notification {
  id: Id;
  location?: string;
  createDate: Date;
  hasRead: boolean;
  meetingName: string;
  startDate?: Date;
}

export interface CancelNotification extends Notification {
  type: "cancel";
}
export interface RemindNotification extends Notification {
  type: "remind";
}

export interface ReassignNotification extends Notification {
  type: "reassign";
  requesterName: string;
  hasConfirm: boolean;
}

export interface ChangeNotification extends Notification {
  type: "change";
  currentDate: Date;
  currentLocation: string;
  originalDate: Date;
  originalLocation: string;
}
