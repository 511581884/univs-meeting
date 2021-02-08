import { Meeting } from "@/types";

const meetings: Meeting[] = [
  {
    id: 1,
    startDate: new Date(2021, 1, 2, 16),
    endDate: new Date(2021, 1, 2, 18),
    location: "西院会议室101",
    name: "辅导员第一次会议",
    host: "王世杰",
    attendees: [
      {
        id: 1,
        name: "李四",
        phone: "5200000",
        isGuest: 1,
        department: {
          id: 2,
          name: "学工部",
        },
      },
      {
        id: 2,
        name: "张三",
        phone: "5200000",
        isGuest: 0,
        department: {
          id: 2,
          name: "学工部",
        },
      },
      {
        id: 3,
        name: "王五",
        phone: "5211111",
        isGuest: 0,
        department: {
          id: 1,
          name: "人事处",
        },
      },
    ],
    files: [
      {
        id: 1,
        name: "表彰大会名单XXX",
        extension: "doc",
      },
      {
        id: 2,
        name: "会议重要红头文件",
        extension: "ppt",
      },
    ],
  },
  {
    id: 3,
    startDate: new Date(2021, 1, 2, 13),
    endDate: new Date(2021, 1, 2, 15),
    location: "西院会议室103",
    host: "somebody",
    name: "辅导员第三次会议",
    attendees: [
      {
        id: 1,
        name: "李四",
        department: {
          id: 1,
          name: "教务办",
        },
      },
    ],
  },
  {
    id: 2,
    startDate: new Date(2021, 1, 3, 16),
    endDate: new Date(2021, 1, 3, 18),
    location: "西院会议室103",
    name: "辅导员第二次会议",
    host: "somebody",
    attendees: [
      {
        id: 1,
        name: "李四",
        department: {
          id: 1,
          name: "教务办",
        },
      },
    ],
  },
  {
    id: 4,
    startDate: new Date(2021, 1, 2, 8),
    endDate: new Date(2021, 1, 1, 10),
    location: "西院会议室103",
    name: "辅导员第二次会议",
    host: "somebody",
    attendees: [
      {
        id: 1,
        name: "李四",
        department: {
          id: 1,
          name: "教务办",
        },
      },
    ],
  },
  {
    id: 5,
    startDate: new Date(2021, 1, 5, 13),
    endDate: new Date(2021, 1, 5, 14),
    location: "西院会议室103",
    host: "somebody",
    name: "辅导员第二次会议",
    attendees: [
      {
        id: 1,
        name: "李四",
        department: {
          id: 1,
          name: "教务办",
        },
      },
    ],
  },
  {
    id: 6,
    startDate: new Date(2021, 1, 6, 12),
    endDate: new Date(2021, 1, 6, 15),
    location: "西院会议室103",
    host: "host",
    name: "辅导员第二次会议",
    attendees: [
      {
        id: 1,
        name: "李四",
        department: {
          id: 1,
          name: "教务办",
        },
      },
    ],
  },
  {
    id: 7,
    startDate: new Date(2021, 1, 7, 8),
    endDate: new Date(2021, 1, 7, 9),
    location: "西院会议室103",
    host: "host",
    name: "辅导员第二次会议",
    attendees: [
      {
        id: 1,
        name: "李四",
        department: {
          id: 1,
          name: "教务办",
        },
      },
    ],
  },
  {
    id: 8,
    startDate: new Date(2021, 1, 6, 8),
    endDate: new Date(2021, 1, 6, 9),
    location: "西院会议室103",
    host: "host",
    name: "辅导员第二次会议",
    attendees: [
      {
        id: 1,
        name: "李四",
        department: {
          id: 1,
          name: "教务办",
        },
      },
    ],
  },
  {
    id: 9,
    startDate: new Date(2021, 1, 10, 14),
    endDate: new Date(2021, 1, 10, 16),
    location: "西院会议室103",
    host: "host",
    name: "辅导员第二次会议",
    attendees: [
      {
        id: 1,
        name: "李四",
        department: {
          id: 1,
          name: "教务办",
        },
      },
    ],
  },
  
];

export const getMeetings = () =>
  new Promise<Meeting[]>((resolve) => {
    resolve(meetings);
  });
