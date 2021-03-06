package net.classicube.launcher;

// Possible "expected" outcomes of a sign-in process.
// For any unexpected ones, use SignInException.
public enum SignInResult {
    SUCCESS,
    WRONG_USER_OR_PASS,
    MIGRATED_ACCOUNT,
    CONNECTION_ERROR,
    CHALLENGE_FAILED;

    public static String getMessage(SignInResult result) {
        switch (result) {
            case WRONG_USER_OR_PASS:
                return "Wrong username or password.";
            case MIGRATED_ACCOUNT:
                return "Your account has been migrated. "
                        + "Use your Mojang account (email) to sign in.";
            case CONNECTION_ERROR:
                return "Connection problem. The website may be down.";
            case CHALLENGE_FAILED:
                return "Wrong answer to the security question. "
                        + "Try again, or reset the security question at "
                        + "<a href=\"https://account.mojang.com/me/changeSecretQuestions\">Mojang.com</a>";
            default:
                return result.name();
        }
    }
}
