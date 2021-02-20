import { NotificationType } from "@/types/notification";
import { get } from "./http";

const END_POINT = "/api/notifications";

export const getNotifications = async () => {
  const { data: notifications } = await get<NotificationType[]>(END_POINT, {
    requireAuth: true,
  });

  return notifications;
};
