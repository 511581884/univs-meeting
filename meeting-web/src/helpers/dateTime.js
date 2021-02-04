import dayjs from "dayjs";

const today = dayjs();

export const areSameDate = (date1, date2) => {
  return dayjs(date1).isSame(dayjs(date2), "date");
};

export const isToday = (date) => {
  return dayjs(date).isSame(today, "date");
};

export const isTomorrow = (date) => {
  const tomorrow = today.add("1", "day");
  return dayjs(date).isSame(tomorrow, "date");
};

export const isBeforeToday = (date) => {
  return dayjs(date).isBefore(today, "date");
};

//Example:
//12:1 -> 12:01
//1:43 -> 01:43
export const formatTime = (value) => {
  return value < 10 ? `0${value}` : value;
};
//Example:
//date === today -> 今天
//date === tomorrow -> 明天
//date > tomorrow -> 具体日期
export const formatDate = (date, showTime = true) => {
  const timeString = showTime
    ? `${formatTime(date.getHours())}:${formatTime(date.getMinutes())}`
    : "";

  if (isToday(date)) return `今天  ${timeString}`;
  if (isTomorrow(date)) return `明天  ${timeString}`;
  return `${date.getMonth() + 1}月${date.getDate()}日  ${timeString}`;
};
