export class UserManagementService {

    private urlBase = "http://localhost:8080";
    private urlUserList = "/api/user/";

    public async findUsers() : Promise<User[]> {
        return fetch(this.urlBase + this.urlUserList)
                .then(response => response.json())
                .then(json => Promise.resolve(json.content))
    }
}