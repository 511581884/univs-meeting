const colleagueOfSomebody = [
  {
    id: 1,
    name: "李四",
    department: {
      id: 1,
      name: "教务办",
    },
  },
  {
    id: 2,
    name: "王五",
    department: {
      id: 1,
      name: "教务办",
    },
  },
  {
    id: 3,
    name: "张人杰",
    department: {
      id: 1,
      name: "教务办",
    },
  },
];

// eslint-disable-next-line no-unused-vars
export const getColleague = (userId) =>
  new Promise((resolve) => {
    resolve(colleagueOfSomebody);
  });

export const sendReassignmentRequest = (targetId, userId, meetingId) => {
  console.log(
    `Id of ${userId}} sent a reassignment request to id of ${targetId}. Asking him/her to attend the meeting with the id of ${meetingId}`
  );

  new Promise(
    (resolve) => {
      resolve("Request sent successfully!");
    },
    (reject) => {
      reject("Request failed for some reason.");
    }
  );
};
