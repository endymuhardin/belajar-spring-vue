interface Role {
    id: string
    name: string
}

interface User {
    id: string
    username: string
    password: string
    active: boolean
    role: Role
}

interface Page<T> {
    content: T[]
    number: number
    first: boolean
    last: boolean
    totalElements: number
    totalPages: number
}