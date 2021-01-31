const meetings = [
  {
    id: 1,
    startDate: new Date(2021, 1, 2, 16),
    endDate: new Date(2021, 1, 2, 18),
    location: "西院会议室101",
    name: "辅导员第一次会议",
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
    id: 3,
    startDate: new Date(2021, 1, 2, 13),
    endDate: new Date(2021, 1, 2, 15),
    location: "西院会议室103",
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
  new Promise((resolve) => {
    resolve(meetings);
  });
