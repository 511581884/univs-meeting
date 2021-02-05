import { Colleague, Id } from "@/types";

const colleagueOfSomebody: Colleague[] = [
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
export const getColleague = (userId: Id) =>
  new Promise<Colleague[]>((resolve) => {
    resolve(colleagueOfSomebody);
  });

export const sendReassignmentRequest = (
  targetId: Id,
  userId: Id,
  meetingId: Id
) => {
  console.log(
    `Id of ${userId}} sent a reassignment request to id of ${targetId}. Asking him/her to attend the meeting with the id of ${meetingId}`
  );

  return new Promise<string>((resolve) =>
    resolve("Request sent successfully!")
  );
};
