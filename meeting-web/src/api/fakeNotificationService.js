const notifications = [
  {
    id: 1,
    type: "cancel",
    hasRead: false,
    meetingName: "学校优秀辅导员座谈会",
    startDate: new Date(2021, 1, 5, 12, 40),
    location: "西院会议室101",
  },
  {
    id: 2,
    type: "remind",
    hasRead: false,
    meetingName: "学校优秀辅导员座谈会",
    startDate: new Date(2021, 1, 4, 11, 40),
    location: "西院会议室101",
  },
  {
    id: 4,
    type: "change",
    hasRead: false,
    meetingName: "学校优秀辅导员座谈会",
    originalDate: new Date(2021, 1, 6, 11, 40),
    currentDate: new Date(2021, 1, 6, 15, 40),
    originalLocation: "西院会议室101",
    currentLocation: "西院会议室101",
  },
  {
    id: 3,
    type: "reassign",
    hasRead: false,
    meetingName: "学校优秀辅导员座谈会",
    startDate: new Date(2021, 1, 3, 11, 40),
    requesterName: "张三",
    location: "西院会议室101",
  },
  {
    id: 5,
    type: "change",
    hasRead: false,
    meetingName: "学校优秀辅导员座谈会",
    originalDate: new Date(2021, 1, 5, 11, 40),
    currentDate: new Date(2021, 1, 5, 11, 40),
    originalLocation: "西院会议室101",
    currentLocation: "西院会议室103",
  },
  {
    id: 6,
    type: "cancel",
    hasRead: false,
    meetingName: "学校优秀辅导员座谈会",
    startDate: new Date(2021, 1, 5, 11, 40),
    location: "西院会议室101",
  },
];

export const getNotifications = () => {
  return new Promise((resolve) => {
    resolve(notifications);
  });
};
