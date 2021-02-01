const meetings = [
  {
    id: 1,
    startDate: new Date(2021, 1, 2, 16),
    endDate: new Date(2021, 1, 2, 18),
    location: "西院会议室101",
    name: "辅导员第一次会议",
    host: '王世杰',
    attendees: [
      {
        id: 1,
        name: "李四",
        phone: '5200000',
        isGuest: 1,
      },
      {
        id: 2,
        name: "张三",
        phone: '5200000',
        isGuest: 0,
        department: {
          id: 2,
          name: "学工部",
        },
      },
      {
        id: 3,
        name: "王五",
        phone: '5211111',
        isGuest: 0,
        department: {
          id: 1,
          name: "人事处",
        },
      },
    ],
    files:[
      {
        id: 1,
        name: "表彰大会名单XXX"
      },
      {
        id: 2,
        name: "会议重要红头文件"
      }
    ]
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
  {
    id: 4,
    startDate: new Date(2021, 2, 2, 8),
    endDate: new Date(2021, 2, 1, 10),
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
  {
    id: 5,
    startDate: new Date(2021, 2, 5, 13),
    endDate: new Date(2021, 2, 5, 14),
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
  {
    id: 5,
    startDate: new Date(2021, 2, 6, 12),
    endDate: new Date(2021, 2, 6, 15),
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
