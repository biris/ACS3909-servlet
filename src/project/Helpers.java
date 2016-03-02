package project;

import com.sun.org.apache.xerces.internal.xni.XMLString;

import javax.servlet.http.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Helpers {

	public static String DOCTYPE = "<!DOCTYPE html>\n";

	public static String getCookieValue(HttpServletRequest request, String cookieName, String defaultValue) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie ck : cookies) {
				if (ck.getName().equals(cookieName)) {
					return ck.getValue();
				}
			}
		}
		return defaultValue;
	}

	public static Collection<Student> getWhoSelectedStudent(Collection<Student> students, Student given) {


		Predicate<Student> selected = s -> s.getSelected().contains(given.getStudentID());

		return
				students.stream()
						.filter(s -> s.getSelected().contains(given.getStudentID()))
						.collect(Collectors.toList());
	}


	public static Collection<Student> filterStudents(Collection<Student> stds, String curID) {
		return stds.stream().filter(s -> !s.getStudentID().equals(curID)).collect(Collectors.toList());
	}

	public static Boolean isNull(Object[] col) {
		return (col == null) ? true: false;
	}

	public static Boolean isNull(Collection col) {
		return (col.size() == 0) ? true: false;
	}


	public static Cookie getCookie(HttpServletRequest request, String cookieName) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie ck : cookies) {
				if (ck.getName().equals(cookieName)) {
					return ck;
				}
			}
		}
		return null;
	}


	public static Boolean isValidID(String str) {
		return str != null && str.length() == 7;
	}


	public static String replaceIfMissing(String orig, String replacement) {
		return ((orig == null) || (orig.trim().equals(""))) ? replacement : orig;
	}



	public static String stringParameters(HttpServletRequest request, String paramName) {
		if (request.getParameterValues(paramName) == null) return "";
		return Arrays.stream(request.getParameterValues(paramName)).collect(Collectors.joining(" "));
	}

	public static String getParameterCheck(HttpServletRequest request, String paramName) {
		return request.getParameter(paramName) != null ? request.getParameter(paramName) : "";
	}

}


