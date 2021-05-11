import dayjs, { Dayjs } from "dayjs";

const today = dayjs();

export const areSameDate = (date1: Date, date2: Date): boolean => {
  return dayjs(date1).isSame(dayjs(date2), "date");
};

export const isToday = (date: Date): boolean => {
  return dayjs(date).isSame(today, "date");
};

export const isTomorrow = (date: Date): boolean => {
  const tomorrow = today.add(1, "day");
  return dayjs(date).isSame(tomorrow, "date");
};

export const isBeforeToday = (date: Date): boolean => {
  return dayjs(date).isBefore(today, "date");
};

//Example:
//12:1 -> 12:01
//1:43 -> 01:43
export const formatTime = (value: number): string => {
  return `${value < 10 ? "0" : ""}${value}`;
};
//Example:
//date === today -> 今天
//date === tomorrow -> 明天
//date > tomorrow -> 具体日期
export const formatDate = (date: Date, showTime = true): string => {
  const timeString = showTime
    ? `${formatTime(date.getHours())}:${formatTime(date.getMinutes())}`
    : "";
  if (isToday(date)) return `今天  ${timeString}`;
  if (isTomorrow(date)) return `明天  ${timeString}`;
  return `${date.getMonth() + 1}月${date.getDate()}日  ${timeString}`;
};


export const isInThisWeek = (date: Date): boolean => {
  const _date = dayjs(date)
  const dayOfWeek = today.get("day") || 7 
  const s = today.add( 1 - dayOfWeek,'day').set('hour',0).set('minute',0).set('second',0)
  const e = today.add( 7 - dayOfWeek,'day').set('hour',23).set('minute',59).set('second',59)
  return _date >=s && _date <= e
}