package Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;

public class Utils {
    private static final Scanner scanner = new Scanner(System.in);
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public static String getValue(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }
    
    public static String getFormattedValue(String prompt, String errMsg, String regex) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (input.matches(regex))
                return input;
            else
                System.out.println(errMsg);
        }
    }

    public static int getIntValue(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
    }
    
    public static int getPosIntValue(String prompt) {
        while (true) {
            int res = getIntValue(prompt);
            if (res < 1) continue;
            return res; 
        }
    }

    public static double getDoubleValue(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid decimal number.");
            }
        }
    }

    public static double getDoubleValueWithErr(String prompt, String errMsg) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println(errMsg);
            }
        }
    }

    public static double getPosDouble(String prompt) {
        while (true) {
            double value = Utils.getDoubleValue(prompt + ": ");
            if (value > 0) {
                return value;
            }
            System.out.println("Please enter a positive number.");
        }
    }

    public static Date getDateValue(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return sdf.parse(scanner.nextLine().trim());
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please use dd/MM/yyyy.");
            }
        }
    }

    public static Date parseDate(String dateStr) {
        try {
            return sdf.parse(dateStr.trim());
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use dd/MM/yyyy.");
            return null;
        }
    }

    public static String formatDate(Date date) {
        return sdf.format(date);
    }

    public static int[] getArray(String prompt) {
        int n = getPosIntValue("Enter the number of the array: ");
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = getPosIntValue(prompt + " [" + (i + 1) + "]: ");
        }
        return array;
    }

    // Get LocalDate with year validation (year must be before current year)
    public static LocalDate getDateValueWithYearCheck(String prompt) {
        while (true) {
            Date date = getDateValue(prompt);
            if (date != null) {
                LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                int currentYear = LocalDate.now().getYear();
                if (localDate.getYear() < currentYear) {
                    return localDate;
                } else {
                    System.out.println("Error: Year of birth must be before current year (" + currentYear + ")!");
                }
            }
        }
    }

    // Convert Date to LocalDate
    public static LocalDate dateToLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    // Convert LocalDate to Date
    public static Date localDateToDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    // Get integer value with range validation
    public static int getIntValueInRange(String prompt, int min, int max, String errMsg) {
        while (true) {
            int value = getIntValue(prompt);
            if (value >= min && value < max) {
                return value;
            } else {
                System.out.println(errMsg);
            }
        }
    }

    // Get double value with minimum validation
    public static double getDoubleValueWithMin(String prompt, double min, String errMsg) {
        while (true) {
            double value = getDoubleValue(prompt);
            if (value >= min) {
                return value;
            } else {
                System.out.println(errMsg);
            }
        }
    }

    // Get double value with range validation
    public static double getDoubleValueInRange(String prompt, double min, double max, String errMsg) {
        while (true) {
            double value = getDoubleValue(prompt);
            if (value >= min && value <= max) {
                return value;
            } else {
                System.out.println(errMsg);
            }
        }
    }
}